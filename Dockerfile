# 使用 Java 11 官方镜像
FROM openjdk:11-jre-slim

# 设置工作目录
WORKDIR /app

# 复制构建好的 jar 包到镜像中
COPY target/crypto_mining-1.0.0.jar app.jar

# 暴露端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]