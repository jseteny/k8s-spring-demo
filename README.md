Telepítés:

1.)
$ mvn clean package

2.)
$ docker build -t lippert/k8s-spring-demo .

3.) Docker local run, jdbc POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD env beállításra szorul:

$ docker run -d -p 8080:8080 --name k8s-spring-demo -e POSTGRES_URL=jdbc:postgresql://192.168.2.214:5434/postgres -e POSTGRES_USER=postgres -e 
POSTGRES_PASSWORD=postgres lippert/k8s-spring-demo

App elérhetőség:
http://localhost:8080/api/persons (DB-ből olvas fel 3 Person rekordot)
http://localhost:8080/api/hi/John
Életjel:
http://localhost:8080/actuator/health



4.) Kubernetes: POSTGRES_URL (configmap-ban), POSTGRES_USER (secret-ben base64), POSTGRES_PASSWORD (secret-ben base64), illetve a docker image elérhetősége (repository) beállításra szorul a yaml fájlban. Én a service type-ot NodePort-ra definiáltam így az api-t ingress nélkül is elérhetitek a generált Node port-on, ebben az esetben töröljétek az Ingress definíciót a yaml-ból. Persze ez csak egy példa, hogy én miként installáltam a Kubernetes-ben.

$ kubectl create namespace telemedicina

$ kubectl create -f k8s-spring-demo.yaml -n telemedicina

az én környezetemben így az app elérhetőség (van egy Nginx reverse proxy is a Kubernetes előtt): 
https://192.168.2.222/k8s-spring-demo/api/persons
vagy NodePort-on (nektek más lesz a node port)
http://192.168.2.222:30803/api/persons

https://192.168.2.222/k8s-spring-demo/api/hi/John
vagy NodePort-on (nektek más lesz a node port)
http://192.168.2.222:30803/api/hi/John

Életjel:
https://192.168.2.222/k8s-spring-demo/actuator/health
vagy NodePort-on (nektek más lesz a node port)
http://192.168.2.222:30803/actuator/health

