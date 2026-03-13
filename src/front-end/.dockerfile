# FROM maven:3.8.2-jdk-8 # for Java 8
FROM node:23-alpine

WORKDIR /starter-project

COPY ./package.json .
RUN npm install

COPY . .

CMD npm run dev