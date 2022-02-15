package server;

import java.util.HashMap;
import java.util.Map;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.CreateUserRequest;
import proto.CreateUserResponse;
import proto.DeleteUserRequest;
import proto.DeleteUserResponse;
import proto.GetUserRequest;
import proto.GetUserResponse;
import proto.ListUserRequest;
import proto.ListUserResponse;
import proto.UpdateUserRequest;
import proto.UpdateUserResponse;
import proto.User;
import proto.UserServiceGrpc;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();
    private int i = 1;

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        System.out.println("Creating User");
        User user = request.getUser();

        user = user.toBuilder().setId(i).setTitulo(request.getUser().getTitulo()).setEndereco(request.getUser().getEndereco()).setTipo(request.getUser().getTipo()).setNumeroQuartos(request.getUser().getNumeroQuartos()).setNumeroGaragens(request.getUser().getNumeroGaragens()).setAreaConstruida(request.getUser().getAreaConstruida()).setAreaTerreno(request.getUser().getAreaTerreno()).setPreco(request.getUser().getPreco())
                .build();

        CreateUserResponse response = CreateUserResponse.newBuilder().setUser(user).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        userMap.put(i, user);
        i++;
    }

    @Override
    public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
        if (userMap.containsKey(request.getUserId())) {
            userMap.remove(request.getUserId());
            System.out.println("User was deleted");
            responseObserver.onNext(DeleteUserResponse.newBuilder().setUserId(request.getUserId()).build());
            responseObserver.onCompleted();
        } else {
            System.out.println("User not found");
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
        System.out.println("Get user");
        if (userMap.containsKey(request.getUserId())) {
            User user = userMap.get(request.getUserId());
            GetUserResponse response = GetUserResponse.newBuilder().setUser(user).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            System.out.println("User not found");
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }

    }

    @Override
    public void listUser(ListUserRequest request, StreamObserver<ListUserResponse> responseObserver) {
        System.out.println("List users");
        ListUserResponse response = ListUserResponse.newBuilder().addAllUser(userMap.values()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UpdateUserResponse> responseObserver) {

        if (userMap.containsKey(request.getUser().getId())) {
 
            System.out.println("Usuario atualizado");

            User user = request.getUser();

            user = user.toBuilder().setId(request.getUser().getId()).setTitulo(request.getUser().getTitulo()).setEndereco(request.getUser().getEndereco()).setTipo(request.getUser().getTipo()).setNumeroQuartos(request.getUser().getNumeroQuartos()).setNumeroGaragens(request.getUser().getNumeroGaragens()).setAreaConstruida(request.getUser().getAreaConstruida()).setAreaTerreno(request.getUser().getAreaTerreno()).setPreco(request.getUser().getPreco())
                    .build();

            UpdateUserResponse response = UpdateUserResponse.newBuilder().setUser(user).build();
       
            userMap.replace(request.getUser().getId(), user);
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } else {
            System.out.println("User not found");
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }

    }

}
