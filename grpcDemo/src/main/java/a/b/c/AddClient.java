package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @auther guannw
 * @create 2021/6/28 21:15
 */
public class AddClient {
    ManagedChannel channel;
    AddServiceGrpc.AddServiceBlockingStub  stub;
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        AddClient addClient = new AddClient();

        AddReply reply = addClient.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(reply.getRes());

    }

    public AddClient(){
         channel = ManagedChannelBuilder
                .forAddress("127.0.0.1",9999)
                 .usePlaintext() //使用纯文本类型
                .build();
         stub =
                 AddServiceGrpc.newBlockingStub(channel);
    }
}
