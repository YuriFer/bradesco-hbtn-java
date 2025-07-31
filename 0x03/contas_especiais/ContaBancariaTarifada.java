import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica{
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        aplicarTarifa();
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        aplicarTarifa();;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    public void aplicarTarifa(){
        quantidadeTransacoes++;
        setSaldo(getSaldo() - 0.10);
    }
}
