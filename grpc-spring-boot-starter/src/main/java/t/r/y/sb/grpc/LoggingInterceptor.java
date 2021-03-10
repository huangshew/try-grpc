package t.r.y.sb.grpc;

import io.grpc.*;
import io.grpc.ServerCall.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class LoggingInterceptor implements ServerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
            final ServerCall<ReqT, RespT> serverCall,
            final Metadata metadata,
            final ServerCallHandler<ReqT, RespT> serverCallHandler) {

        log.info(serverCall.getMethodDescriptor().getFullMethodName());
        final InetSocketAddress address = (InetSocketAddress) serverCall.getAttributes()
                .get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
        log.info(address.getHostString());
        return serverCallHandler.startCall(serverCall, metadata);
    }

}
