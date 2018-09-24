package view;

public class Constants {
    public static final String VERSION = "1.0.0";
    public static final boolean PORTUGUESE = false;
    public static final String[] LAUNCHER_EN = {
        "Data Structure Viewer", "Data Structure Project", "Sequential List", "Singly Linked List", "Doubly Linked List", "Stack", "Queue", "Tree", "Graph", "Version " + VERSION
    };
    public static final String[] LAUNCHER_PT = {
        "Data Structure Viewer", "Projeto de Estrutura de Dados", "Lista Sequencial", "Lista Simplesmente Encadeada", "Lista Duplamente Encadeada", "Pilha", "Fila", "�rvore", "Grafo", "Vers�o " + VERSION  
    };
    
    public static final String[] LIST_PT = {"Nova Lista", "Carregar", "Salvar", "Adicionar", "Modificar", "Remover", "Buscar", "Vazia",//0-7 buttons
        "Insira o tamanho m�ximo da lista (Digite 0 para o tamanho padr�o)", "Tamanho Atual: ", "         Tamanho M�ximo: ",//btCreate 8-10
        "Come�o", "Fim", "Em uma dada posi��o", "Cancelar", "Onde voc� gostaria de adicionar um elemento:", "Insira o valor", "Insira a posi��o onde voc� gostaria de adicionar ",//btAdd 11-17
        "Por valor", "Por posi��o", "Cancelar", "Como voc� gostaria de buscar na lista?", "Digite o valor a ser procurado:", "Digite a posi��o a ser procurada:", "Valor em posi��o ",//18-24 btSearch
        
         
    };
    
    public static final String[] ERRORS_PT = {
        "O tamanho deve ser um inteiro positivo!",
        "O Valor deve ser um inteiro",
        "A Posi��o deve ser um inteiro!",
        "O elemento deve ser um inteiro!",
        "A posi��o e o valor devem ser inteiros!",
        "O arquivo escolhido n�o � uma lista sequencial v�lida!",
        "Erro desconhecido"
    };
}
