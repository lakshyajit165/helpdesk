#stage 1
# FROM node:latest as node
# WORKDIR /command-registry-ui
# COPY . .
# RUN npm install -g @angular/cli
# RUN ng build --prod

# #stage 2
# FROM nginx
# COPY --from=node /command-registry-ui/dist/* /usr/share/nginx/html/
# EXPOSE 4200

FROM node:alpine AS builder
WORKDIR /src/app
COPY . .
RUN npm install && \
npm run build
FROM nginx:alpine
COPY --from=builder /src/app/dist/* /usr/share/nginx/html/