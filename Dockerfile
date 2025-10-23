# 第一阶段：编译阶段，基于 openjdk:11 镜像（含编译工具）
FROM openjdk:11 AS builder
WORKDIR /app
# 复制 pom.xml 和 src 目录
COPY pom.xml .
COPY src ./src
# 执行 mvn package 编译生成 jar 包
RUN mvn clean package -DskipTests

# 第二阶段：运行阶段，基于 openjdk:11-jre-slim 镜像（仅运行时依赖）
FROM openjdk:11-jre-slim
WORKDIR /app
# 从编译阶段复制生成的 jar 包
COPY --from=builder /app/target/crypto_mining-1.0.0.jar app.jar
# 暴露端口
EXPOSE 8080
# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]