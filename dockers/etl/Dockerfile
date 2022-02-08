FROM python:3.9
MAINTAINER wenliangz@gmail.com

COPY ./dockers/etl/requirements.txt /app/
COPY ./etl.py /app/etl.py
COPY ./utilities/ /app/utilities/
#COPY ./data/ /app/data/
#COPY ./configs/ /app/configs/
WORKDIR /app
RUN pip install -r requirements.txt

#COPY ./dockers/etl/entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh
#ENTRYPOINT ["/entrypoint.sh"]

