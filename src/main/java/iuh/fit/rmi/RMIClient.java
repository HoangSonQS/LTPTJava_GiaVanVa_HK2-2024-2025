package iuh.fit.rmi;

import iuh.fit.entities.CaLam;
import iuh.fit.interfaces.CaLam_interface;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;

public class RMIClient {

    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();

        CaLam_interface caLamDAO = (CaLam_interface) context.lookup("rmi://LAPTOP-O8OOBHDK:9090/caLamDAO");

        List<CaLam> caLams = caLamDAO.readAll();

        System.out.println("Retrieved " + caLams.size() + " CaLam records:");
        for (CaLam caLam : caLams) {
            System.out.println(caLam);
        }
    }
}
