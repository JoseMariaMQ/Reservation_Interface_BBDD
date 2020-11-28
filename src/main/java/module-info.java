module DI_CP1_UD3_BBDD {
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires com.sun.xml.bind;
    requires net.bytebuddy;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires com.fasterxml.classmate;

    opens accessingDataBase to javafx.fxml;
    opens prueba to com.fasterxml.classmate, org.hibernate.orm.core;
    exports accessingDataBase;
    exports prueba;
}