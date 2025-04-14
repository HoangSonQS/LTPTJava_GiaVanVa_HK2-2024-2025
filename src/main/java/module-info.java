module module_name {
    requires jakarta.persistence;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires static lombok;
    requires net.datafaker;
    requires java.rmi;
    requires java.naming;

    opens iuh.fit;
    opens iuh.fit.entities to org.hibernate.orm.core;
    opens iuh.fit.daos;
    opens iuh.fit.interfaces;
    opens iuh.fit.rmi;
}