package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
            refIhm.afficheMessage("");
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("La chaîne " + value + " n'est pas valide");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;
        refIhm.afficheMessage("");

        try {
            valueAreaDouble = Double.parseDouble(valueArea);
        } catch (NumberFormatException e) {

            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle ( " + valueArea + " invalide ) ");
        }
        try {
            refIhm.afficheMessage("");
            valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));

        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour longueur du rectangle ( " + valueLongueur + " invalide ) ");
        } catch (ArithmeticException e) {
            refIhm.afficheMessage("Veuillez entrer une longueur, 0 non divisible. ");

        }

    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
