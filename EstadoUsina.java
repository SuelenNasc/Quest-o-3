/**
 * Esta é a interface State (EstadoUsina).
 * * DECISÃO DE DESIGN:
 * Define todas as ações possíveis que podem ser delegadas
 * pelo Contexto (UsinaNuclear). 
 * * APLICANDO SOLID (Substituição de Liskov - L):
 * Qualquer classe que implemente esta interface pode ser 
 * substituída no Contexto (UsinaNuclear) sem quebrar o sistema.
 */
public interface EstadoUsina {

    // Ação principal de verificação de regras
    void verificarCondicoes(UsinaNuclear usina);

    // Ações de controle
    void iniciar(UsinaNuclear usina);
    void desligar(UsinaNuclear usina);
    
    // Ações de manutenção (requisito 5)
    void iniciarManutencao(UsinaNuclear usina);
    void finalizarManutencao(UsinaNuclear usina);
}