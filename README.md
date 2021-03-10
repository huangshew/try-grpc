# try-grpc

[[_TOC_]]

## Hello World

A starter project created on 20210301, following [
yrrhelp Youtube Tutorial](https://www.youtube.com/playlist?list=PLI5t0u6ye3FGXJMh5kU2RvN0xrul67p7R).
### hello-world-server

The proto resides under `./src/main/resource`.

Since default goal is configured for `mvn`, to generate the Java classes, use

```bash
mvn install
```

Server implementation is at class `t.r.y.ServerApp`.

### hello-world-client

Run the main method. Or try [BloomRPC](https://github.com/uw-labs/bloomrpc)


## grpc-spring-boot-starter

Trying `Spring Boot starter module for gRPC framework` on 20210309, following [
Getting Started
](https://yidongnan.github.io/grpc-spring-boot-starter/en/server/getting-started.html).

### Maven Protocol Buffers Plugin 

The package is [here](https://www.xolstice.org/protobuf-maven-plugin/). Notes below:

1. proto files are under `src/main/proto`.
2. If no explicit `java_package option` is given in the .proto file, then by default the proto package (specified using the `package` keyword in the .proto file) will be used.
3. `mvn clean protobuf:compile protobuf:compile-custom` generates source code in `target/generated-sources/protobuf/*`.
4. The use of `repeated`.

TODO
1. Global Interceptor
2. Exception Handling
3. RxJava




