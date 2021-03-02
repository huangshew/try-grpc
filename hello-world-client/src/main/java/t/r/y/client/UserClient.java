package t.r.y.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import t.r.y.grpc.UserGrpc;
import t.r.y.grpc.UserOuterClass;

public class UserClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        UserGrpc.UserBlockingStub userStub = UserGrpc.newBlockingStub(channel);
        UserOuterClass.GeneralResponse response = userStub.login(UserOuterClass.LoginRequest.newBuilder()
                .setUsername("hello").setPassword("hello").build());

        System.out.println(response.getResponseMessage());
    }
}
