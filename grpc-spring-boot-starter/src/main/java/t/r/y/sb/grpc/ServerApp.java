package t.r.y.sb.grpc;

import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApp {

    public static void main(final String[] args) {
        SpringApplication.run(ServerApp.class, args);
    }

    @GrpcGlobalServerInterceptor
    ServerInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
