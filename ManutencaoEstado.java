/**
 * Estado Concreto: Manutenção (Requisito 5)
 * * DECISÃO DE DESIGN:
 * Este estado "sobreescreve" os outros ao se tornar o estado ativo.
 * Para atender ao requisito de retornar ao estado anterior,
 * ele armazena uma referência (estadoAnterior) ao estado
 * que estava ativo antes da manutenção começar.
 */
public class ManutencaoEstado extends EstadoBase {

    private EstadoUsina estadoAnterior;

    /**
     * Usado pelos outros estados (Desligada, Normal) para 
     * configurar o "caminho de volta" antes da transição.
     */
    public void setEstadoAnterior(EstadoUsina estado) {
        this.estadoAnterior = estado;
    }

    @Override
    public void finalizarManutencao(UsinaNuclear usina) {
        // Ação VÁLIDA: Retorna ao estado em que estava
        System.out.println("[AÇÃO] Manutenção concluída. Retornando ao estado operacional anterior.");
        if (this.estadoAnterior != null) {
            usina.setEstado(this.estadoAnterior);
            this.estadoAnterior = null; // Limpa a referência
        } else {
            // Fallback de segurança, caso algo dê errado
            usina.setEstado(usina.getDesligadaEstado());
        }
    }
    
    // Todas as outras ações (iniciar, desligar, verificarCondicoes)
    // são inválidas por padrão (herdadas), simulando que
    // a usina está "travada" em manutenção.
}