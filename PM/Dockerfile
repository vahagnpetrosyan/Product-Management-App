FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=build/unpacked
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/static /app/static
COPY ${DEPENDENCY}/BOOT-INF/classes /app
CMD ["java","-cp","app:app/lib/*","com.products.products.ProductsApplication"]