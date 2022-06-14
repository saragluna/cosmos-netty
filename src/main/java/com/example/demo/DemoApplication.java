package com.example.demo;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.util.CosmosPagedIterable;

import java.util.UUID;

public class DemoApplication {

	public static void main(String[] args) {
        CosmosClient cosmosClient = new CosmosClientBuilder()
            .endpoint("put-your-endpoint-here")
            .key("put-your-key-here")
            .buildClient();

        CosmosDatabase database = cosmosClient.getDatabase("my-database");
        CosmosContainer container1 = database.getContainer("container1");

        String id = UUID.randomUUID().toString();
        container1.createItem(new User(id, "user" + id, "addr" + id));
        CosmosPagedIterable<User> users = container1.queryItems("select * from container1",
            new CosmosQueryRequestOptions(), User.class);
        users.forEach(System.out::println);
        System.exit(0);
    }

}
