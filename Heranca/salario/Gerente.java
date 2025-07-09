public class Gerente extends Empregado {
        public Gerente(double salarioFixo) {
            super(salarioFixo);
        }

        @Override
        public double calcularBonus(Departamento departamento) {
            double bonusPercentual;

            if(departamento.alcancouMeta()){
                double diferencaBonusDepartamento = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
                bonusPercentual = 0.01 * diferencaBonusDepartamento;
            }
            else {
                bonusPercentual = 0.0;
            }

            return departamento.alcancouMeta() ? (0.2 * getSalarioFixo()) + bonusPercentual : 0.0;
        }
    }
