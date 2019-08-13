
My variant:

15. Система Служба Такси. Клиент регистрируется в системе и может создавать заказ на Такси, указывая адрес и тип авто. Программа рассчитывает стоимость поездки в зависимости от дистанции, клиентской скидки и/или акции. Система поддерживает программу Лояльности - рассчитывается скидка в зависимости от суммы потраченной суммы. Также могут действовать акционные предложения. После подтверждения Заказа клиентом, Система ищет свободное такси, соответствующее по типу авто. После чего Клиента оповещают, найдено ли Такси и какое время ожидания. 

How to run on PC:
1) Download this project and choose folder where will be locale this project
2) Execute `taxi_database.sql` script in your database (location: "Taxi Service\src\main\resources\database")
3) Change to your database properties in "Taxi Service\src\main\resources\db.properties"
4) Open command prompt in folder where project locale
5) copy this line: "mvn clean tomcat7:run" and paste it in command prompt
6) open this link in your browser "http://localhost:8088/taxi-Kyiv/homePage"
