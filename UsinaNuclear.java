/**
 * Esta é a classe "Contexto" do Padrão State.
 * * DECISÃO DE DESIGN:
 * A Usina em si não sabe a lógica de nenhum estado. Ela apenas armazena
 * os dados dos sensores (o "contexto complexo") e delega todas as
 * ações para o seu objeto de estado atual (`estadoAtual`).
 * * APLICANDO SOLID (Inversão de Dependência - D):
 * A UsinaNuclear (alto nível) depende da abstração `EstadoUsina`,
 * e não de implementações concretas (baixo nível) como `OperacaoNormalEstado`.
 * * Ela também armazena instâncias de todos os estados (como um Flyweight)
 * para evitar a criação de novos objetos a cada transição.
 */
public class UsinaNuclear {

    // --- Instâncias de todos os estados possíveis ---
    private EstadoUsina desligadaEstado;
    private EstadoUsina operacaoNormalEstado;
    private EstadoUsina alertaAmareloEstado;
    private EstadoUsina alertaVermelhoEstado;
    private EstadoUsina emergenciaEstado;
    private ManutencaoEstado manutencaoEstado; // Manutenção é especial

    // --- O estado atual da usina ---
    private EstadoUsina estadoAtual;

    // --- "Contexto Complexo" (Dados dos Sensores) ---
    private double temperaturaReator;
    private double pressaoVapor;
    private boolean sistemaResfriamentoOK;

    public UsinaNuclear() {
        // Inicializa todos os estados, passando a si mesma (o Contexto)
        this.desligadaEstado = new DesligadaEstado();
        this.operacaoNormalEstado = new OperacaoNormalEstado();
        this.alertaAmareloEstado = new AlertaAmareloEstado();
        this.alertaVermelhoEstado = new AlertaVermelhoEstado();
        this.emergenciaEstado = new EmergenciaEstado();
        this.manutencaoEstado = new ManutencaoEstado();
        
        // Estado inicial
        this.estadoAtual = this.desligadaEstado;

        // Condições iniciais
        this.temperaturaReator = 25.0;
        this.pressaoVapor = 1.0;
        this.sistemaResfriamentoOK = true;
    }

    // --- Métodos de Ação (Delegam ao Estado) ---
    // O cliente interage com a Usina através destes métodos.

    public void iniciar() {
        estadoAtual.iniciar(this);
    }

    public void desligar() {
        estadoAtual.desligar(this);
    }

    public void iniciarManutencao() {
        estadoAtual.iniciarManutencao(this);
    }

    public void finalizarManutencao() {
        estadoAtual.finalizarManutencao(this);
    }

    /**
     * Este é o método de "tick" do sistema.
     * O estado atual irá verificar os sensores e decidir se deve
     * transicionar para um novo estado.
     */
    public void verificarCondicoes() {
        System.out.println("[Usina] Verificando sensores: Temp=" + temperaturaReator + "°C, Resfriamento=" + sistemaResfriamentoOK);
        estadoAtual.verificarCondicoes(this);
    }


    // --- Setters (para simulação) e Getters (para os Estados) ---

    // Método de transição usado pelos Estados
    void setEstado(EstadoUsina novoEstado) {
        System.out.println("-------------------------------------------------------");
        System.out.println("[SISTEMA] Transição de Estado: " + 
                            estadoAtual.getClass().getSimpleName() + " -> " + 
                            novoEstado.getClass().getSimpleName());
        System.out.println("-------------------------------------------------------");
        this.estadoAtual = novoEstado;
    }
    
    // Getters para os estados
    public EstadoUsina getDesligadaEstado() { return desligadaEstado; }
    public EstadoUsina getOperacaoNormalEstado() { return operacaoNormalEstado; }
    public EstadoUsina getAlertaAmareloEstado() { return alertaAmareloEstado; }
    public EstadoUsina getAlertaVermelhoEstado() { return alertaVermelhoEstado; }
    public EstadoUsina getEmergenciaEstado() { return emergenciaEstado; }
    public ManutencaoEstado getManutencaoEstado() { return manutencaoEstado; }

    // Getters/Setters para os sensores
    public double getTemperaturaReator() { return temperaturaReator; }
    public void setTemperaturaReator(double temperatura) { this.temperaturaReator = temperatura; }
    public boolean isSistemaResfriamentoOK() { return sistemaResfriamentoOK; }
    public void setSistemaResfriamentoOK(boolean status) { this.sistemaResfriamentoOK = status; }
}