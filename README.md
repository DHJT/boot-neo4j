# boot-neo4j


- Neo4jTemplate 类至少从 Spring Data Neo4j 6.0 版本开始就已经是稳定可用的 API。
- 对于使用 Spring Boot 的项目，通常当 Spring Boot 的版本达到 2.x 时（具体取决于 x 的值），Spring Data Neo4j 的版本也会是 6.x 或更高，从而可以使用 Neo4jTemplate。
- `SpringBoot` `2.3.12.RELEASE`是支持Neo4j嵌入式连接的最后一个Boot版本，但是这个版本不提供`Neo4jTemplate`。
- `SpringBoot` `2.4.0`是开始提供`Neo4jTemplate`支持。
