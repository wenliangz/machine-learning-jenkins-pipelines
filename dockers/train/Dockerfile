FROM python:3.9
MAINTAINER wenliangz@gmail.com

COPY ./dockers/etl/requirements.txt /app/
COPY ./train.py /app/train.py
COPY ./utilities/ /app/utilities/
#COPY ./data/ /app/data/
#COPY ./configs/ /app/configs/
WORKDIR /app
RUN pip install -r requirements.txt
#CMD ["uvicorn", "scripts.api_main:app", "--reload"]