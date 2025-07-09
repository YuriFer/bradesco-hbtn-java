public class Empregado {
        private double salarioFixo;

        public Empregado(double salarioFixo) {
            this.salarioFixo = salarioFixo;
        }

        public double getSalarioFixo() {
            return salarioFixo;
        }

        public double calcularSalarioTotal(Departamento departamento) {
            return salarioFixo + calcularBonus(departamento);
        }

        public double calcularBonus(Departamento departamento) {
            return departamento.alcancouMeta() ? (0.1 * getSalarioFixo()) : 0.0;
        }
    }
