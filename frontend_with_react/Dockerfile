FROM node:latest as app_node

WORKDIR /app

COPY package.json ./

RUN npm install

COPY ./ /app/

RUN npm run build

FROM nginx:latest


COPY --from=app_node /app/build /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
