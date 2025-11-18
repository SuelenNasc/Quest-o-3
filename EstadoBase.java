/**
 * Classe Abstrata (Boa Prática).
 * * DECISÃO DE DESIGN:
 * Implementa a interface State com comportamento padrão:
 * todas as ações são "inválidas" por padrão.
 * * APLICANDO SOLID (Segregação de Interface - I):
 * As classes concretas (como EmergenciaEstado) não são forçadas
 * a implementar métodos que não fazem sentido para elas (como iniciar()).
 * Elas herdam o comportamento "inválido" e sobrescrevem *apenas*
 * as ações e transições que são válidas para aquele estado.
 */
public abstract class EstadoBase implements EstadoUsina {

    protected void logAcaoInvalida(String acao) {
        System.out.println("[AVISO] Ação '" + acao + "' é inválida para o estado atual: " + this.getClass().getSimpleName());
    }

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // Por padrão, a maioria dos estados não reage
        // passivamente a mudanças (só os de operação/alerta)
    }

    @Override
    public void iniciar(UsinaNuclear usina) {
        logAcaoInvalida("iniciar");
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        logAcaoInvalida("desligar");
    }

    @Override
    public void iniciarManutencao(UsinaNuclear usina) {
        logAcaoInvalida("iniciarManutencao");
    }

    @Override
    public void finalizarManutencao(UsinaNuclear usina) {
        logAcaoInvalida("finalizarManutencao");
    }
}