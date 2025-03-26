module hsf302_se1868vj_he187349_lab02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires java.desktop;
    opens hsf302.se1868vj.he187349.entity to org.hibernate.orm.core;
    exports hsf302.se1868vj.he187349.entity;
    opens hsf302.se1868vj.he187349 to javafx.fxml;
    exports hsf302.se1868vj.he187349;

    exports hsf302.se1868vj.he187349.controller;
    opens hsf302.se1868vj.he187349.controller to javafx.fxml;
}