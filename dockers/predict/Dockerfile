FROM python:3.9
MAINTAINER wenliangz@gmail.com

COPY ./dockers/predict/requirements.txt /app/
COPY ./predict.py /app/predict.py
COPY ./utilities/ /app/utilities/
#COPY ./data/ /app/data/
#COPY ./configs/ /app/configs/
WORKDIR /app
RUN pip install -r requirements.txt