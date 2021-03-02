package t.r.y;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import t.r.y.service.UserService;

import java.io.IOException;

public class ServerApp {


    public static void main(String[] args) throws IOException, InterruptedException {
        Server server  = ServerBuilder.forPort(9090).addService(new UserService()).build();
        server.start();

        System.out.println("Server started at port: " + server.getPort());

        server.awaitTermination();
    }
}
