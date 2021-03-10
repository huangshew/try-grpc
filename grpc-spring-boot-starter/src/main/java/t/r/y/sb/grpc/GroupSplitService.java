package t.r.y.sb.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import t.r.y.sb.grpc.lib.GroupAssignment;
import t.r.y.sb.grpc.lib.GroupSplitReply;
import t.r.y.sb.grpc.lib.GroupSplitRequest;
import t.r.y.sb.grpc.lib.GroupSplitServiceGrpc;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class GroupSplitService extends GroupSplitServiceGrpc.GroupSplitServiceImplBase {

    public static final int DEFAULT_TOTAL_GROUPS = 3;

    @Override
    public void split(final GroupSplitRequest request,
                      final StreamObserver<GroupSplitReply> responseObserver) {

        if (request.getUserIdCount() <= 0) {
            throw new RuntimeException("User Id list must not be empty");
        }

        final int totalGroups = request.getTotalGroups() <= 0 ? DEFAULT_TOTAL_GROUPS : request.getTotalGroups();

        final GroupSplitReply.Builder replyBuilder = GroupSplitReply.newBuilder();
        replyBuilder.setTotalGroups(totalGroups);

        final List<GroupAssignment> assignmentList = request.getUserIdList().stream()
                .map(userId -> {
                    int assignedGroupId = (int) this.hash(userId) % totalGroups;
                    return GroupAssignment.newBuilder()
                            .setUserId(userId)
                            .setAssignedGroupId(assignedGroupId)
                            .build();
                })
                .collect(Collectors.toList());

        replyBuilder.addAllAssignments(assignmentList);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }

    private long hash(final int userId) {
        // prime number as a easy impl;
        // should use a hashing function like murmur3
        return (20000L + userId) % 201;
    }


}
