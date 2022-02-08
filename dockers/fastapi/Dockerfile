FROM python:3.9
MAINTAINER wenliangz@gmail.com

COPY ./dockers/fastapi/requirements.txt /app/
COPY ./api_main.py /app/api_main.py
COPY ./utilities/ /app/utilities/
WORKDIR /app
RUN pip install -r requirements.txt
#CMD ["uvicorn", "scripts.api_main:app", "--reload"]