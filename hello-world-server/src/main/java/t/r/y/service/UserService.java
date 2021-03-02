package t.r.y.service;

import io.grpc.stub.StreamObserver;
import t.r.y.grpc.UserGrpc;
import t.r.y.grpc.UserOuterClass;
import t.r.y.grpc.UserOuterClass.GeneralResponse;

public class UserService extends UserGrpc.UserImplBase {

    @Override
    public void login(UserOuterClass.LoginRequest request, StreamObserver<GeneralResponse> responseObserver) {

        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();

        GeneralResponse.Builder builder = GeneralResponse.newBuilder();

        if (username != null && username.equals(password)) {
             builder.setResponseMessage("SUCCESS");
        } else {
            builder.setResponseMessage("INVALID USER AND PASS");
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(UserOuterClass.Empty request, StreamObserver<GeneralResponse> responseObserver) {
    }
}
