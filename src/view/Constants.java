package view;

public class Constants {
    public static final String VERSION = "1.0.0";
    public static final boolean PORTUGUESE = false;
    public static final String[] LAUNCHER_EN = {
        "Data Structure Viewer", "Data Structure Project", "Sequential List", "Singly Linked List", "Doubly Linked List", "Stack", "Queue", "Tree", "Graph", "Version " + VERSION
    };
    public static final String[] LAUNCHER_PT = {
        "Data Structure Viewer", "Projeto de Estrutura de Dados", "Lista Sequencial", "Lista Simplesmente Encadeada", "Lista Duplamente Encadeada", "Pilha", "Fila", "Árvore", "Grafo", "Versão " + VERSION  
    };
    
    public static final String[] LIST_PT = {"Nova Lista", "Carregar", "Salvar", "Adicionar", "Modificar", "Remover", "Buscar", "Vazia",//0-7 buttons
        "Insira o tamanho máximo da lista (Digite 0 para o tamanho padrão)", "Tamanho Atual: ", "         Tamanho Máximo: ",//btCreate 8-10
        "Começo", "Fim", "Em uma dada posição", "Cancelar", "Onde você gostaria de adicionar um elemento:", "Insira o valor", "Insira a posição onde você gostaria de adicionar ",//btAdd 11-17
        "Por valor", "Por posição", "Cancelar", "Como você gostaria de buscar na lista?", "Digite o valor a ser procurado:", "Digite a posição a ser procurada:", "Valor em posição ",//18-24 btSearch
        
         
    };
    
    public static final String[] ERRORS_PT = {
        "O tamanho deve ser um inteiro positivo!",
        "O Valor deve ser um inteiro",
        "A Posição deve ser um inteiro!",
        "O elemento deve ser um inteiro!",
        "A posição e o valor devem ser inteiros!",
        "O arquivo escolhido não é uma lista sequencial válida!",
        "Erro desconhecido"
    };
}
