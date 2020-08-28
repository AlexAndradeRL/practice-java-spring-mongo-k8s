### Project Name
practice-java-spring-mongo-k8s

### Project Description
Practice K8S application, consists of a REST API with 3 endpoints
for creating some dummy `UUID Entities`.

Project has 3 components:
* Java Application
* MongoDB
* Mongo Express

##### Mongo Express was added to easy view DB documents and to add a little bit more of complexity

### Running with docker-compose
```shell script
docker-compose up
```

#### Basic Endpoints:

`POST` - `http://localhost:8080/uuids` - `(no body request)`
##### Response Body
```json
{
    "id": "5f497782ae8ae5628bbc067d",
    "uuid": "32bfcd95-6b8b-43ee-936d-b307930dc1bf"
}
```
you can call `POST` endpoint several times for creating more entities...

### Test Fetching back some entities:
`GET` - `http://localhost:8080/uuids`
##### Response Body
```json
[
    {
        "id": "5f494e13358d37646862e193",
        "uuid": "b651d94f-60a3-4ce9-81ad-2b0d84b6facc"
    },
    {
        "id": "5f494e13358d37646862e194",
        "uuid": "3d16b0b6-88de-45dc-adbd-4129895a2425"
    },
    {
        "id": "5f494e14358d37646862e195",
        "uuid": "e840d5fc-b39c-4f2b-8a1a-04e57d2c1223"
    },
    {
        "id": "5f494e14358d37646862e196",
        "uuid": "cfa06294-6d64-4c50-8f4a-a75f88d9d2ff"
    }
]
```

### Tear down docker-compose
```shell script
docker-compose down
```

---

### Create K8s Cluster
```shell script
# kubectl apply -f k8s/
service/app-service created
deployment.apps/app-deployment created
service/mongo-express-service created
deployment.apps/mongo-express-deployment created
service/mongo created
deployment.apps/mongo created
persistentvolumeclaim/mongo-pvc created
```

## Test again the application

Get your `Cluster IP` 
```shell script
# minikube ip
192.168.64.3
``` 

Get `app-service` running `PORT` (must be 30000)
```shell script
kubectl get services | grep app-service
app-service             NodePort    10.97.234.80    <none>        8080:30000/TCP    6m
``` 

Go back to consume endpoints but replace your `host` and `port` values<br>
`POST` - `http://192.168.64.3:30000/uuids` - `(no body request)`<br>
`GET` - `http://192.168.64.3:30000/uuids`

<br>
You can access `Mongo Express` the same way using `minikube IP` and `mongo-express k8s service`,
`port` must be (30002)

```shell script
# kubectl get services | grep mongo-express-service
mongo-express-service   NodePort    10.104.40.44    <none>        8081:30002/TCP    10m
```

In a web browser go to: `http://192.168.64.3:30002/db/exampleDB/uuidEntities`

### K8s tear down
After you are done, just run:
```shell script
# kubectl delete -f k8s
service "app-service" deleted
deployment.apps "app-deployment" deleted
service "mongo-express-service" deleted
deployment.apps "mongo-express-deployment" deleted
service "mongo" deleted
deployment.apps "mongo" deleted
persistentvolumeclaim "mongo-pvc" deleted
```
