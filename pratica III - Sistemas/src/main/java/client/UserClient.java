package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.CreateUserRequest;
import proto.CreateUserResponse;
import proto.DeleteUserRequest;
import proto.DeleteUserResponse;
import proto.GetUserRequest;
import proto.GetUserResponse;
import proto.ListUserRequest;
import proto.ListUserResponse;
import proto.User;
import proto.UserServiceGrpc;

public class UserClient {

	public static void main(String[] args) {
		UserClient main = new UserClient();
		main.run();
	}

	private void run() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		UserServiceGrpc.UserServiceBlockingStub userClient = UserServiceGrpc.newBlockingStub(channel);

		// CREATE USER
		User user = User.newBuilder().setTitulo("Casa na praia").setEndereco("Rua Joaquim Nambuco 2020").setTipo("casa").setNumeroQuartos(3).setNumeroGaragens(5).setAreaConstruida(255).setAreaTerreno(600).setPreco(385000).build();
		CreateUserResponse createUserResponse = userClient
				.createUser(CreateUserRequest.newBuilder().setUser(user).build());
		System.out.println(createUserResponse.toString());
		
		
		int userId = createUserResponse.getUser().getId();
		
		System.out.println("**********");
		
		User user2 = User.newBuilder().setTitulo("Aparatamento bem localizado").setEndereco("Rua dos Venancios").setTipo("apartamento").setNumeroQuartos(2).setNumeroGaragens(1).setAreaConstruida(80).setAreaTerreno(80).setPreco(152000).build();
		CreateUserResponse createUserResponse2 = userClient
				.createUser(CreateUserRequest.newBuilder().setUser(user).build());
		System.out.println(createUserResponse.toString());
		
		// Get USER 
		System.out.println("********** GET USER");
		
		GetUserResponse getUserResponse = userClient.getUser(GetUserRequest.newBuilder().setUserId(userId).build());
		System.out.println(getUserResponse.getUser());

		// DELETE USER
		System.out.println("********** DELETE USER");
		DeleteUserResponse deleteUserResponse = userClient
				.deleteUser(DeleteUserRequest.newBuilder().setUserId(userId).build());;
		System.out.println(deleteUserResponse.getUserId());

		// LIST USERS
		System.out.println("********** LIST USER");
		ListUserResponse listUserResponse = userClient.listUser(ListUserRequest.newBuilder().build());
		System.out.println(listUserResponse.getUserList());
		
		
		
	}
}
