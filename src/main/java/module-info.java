module gvv.ltptjava_gvv_hk220242025 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens gvv.ltptjava_gvv_hk220242025 to javafx.fxml;
    exports gvv.ltptjava_gvv_hk220242025;
}