package a.b.c;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import static a.b.c.AddServiceGrpc.getAddMethod;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * @auther guannw
 * @create 2021/6/28 21:05
 */
public class AddServer extends AddServiceGrpc.AddServiceImplBase {

    public static void main(String[] args) throws IOException {
        ServerBuilder.forPort(9999)//设置端口
                .addService(new AddServer())// 添加服务
                .build() //创建服务
                .start();//开始服务
        System.out.println("server start at 9999");
        while (true){

        }
    }
    public void add(AddRequest request, StreamObserver<AddReply> responseObserver) {
//        asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
        int res = myAdd(request.getA(),request.getB());
        //返回值
        responseObserver.onNext(AddReply.newBuilder().setRes(res).build());
        //结束
        responseObserver.onCompleted();
    }

    private int myAdd(int a , int b){
        return  a + b ;
    }
}
