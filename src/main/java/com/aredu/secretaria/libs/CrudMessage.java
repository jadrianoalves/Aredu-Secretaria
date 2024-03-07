package com.aredu.secretaria.libs;

public class CrudMessage {
    private final String listSuccessMessage;
    private final String listErrorMessage;
    private final String getByIdSuccessMessage;
    private final String getByIdErrorMessage;
    private final String saveSuccessMessage;
    private final String saveErrorMessage;
    private final String updateSuccessMessage;
    private final String updateErrorMessage;
    private final String deleteSuccessMessage;
    private final String deleteErrorMessage;

    public CrudMessage(String singularClassName, String pluralClassName) {
        this.listSuccessMessage = "Lista de " + pluralClassName + " recuperada com sucesso.";
        this.listErrorMessage = "Erro ao recuperar lista de " + pluralClassName + ".";
        this.getByIdSuccessMessage = singularClassName + " encontrado.";
        this.getByIdErrorMessage = singularClassName + " não encontrado.";
        this.saveSuccessMessage = singularClassName + " salvo com sucesso.";
        this.saveErrorMessage = "Erro ao salvar " + singularClassName + ".";
        this.updateSuccessMessage = singularClassName + " atualizado com sucesso.";
        this.updateErrorMessage = "Erro ao atualizar " + singularClassName + ".";
        this.deleteSuccessMessage = singularClassName + " deletado com sucesso.";
        this.deleteErrorMessage = "Erro ao deletar " + singularClassName + ".";
    }

    public String getListSuccessMessage() {
        return listSuccessMessage;
    }

    public String getListErrorMessage() {
        return listErrorMessage;
    }

    public String getGetByIdSuccessMessage() {
        return getByIdSuccessMessage;
    }

    public String getGetByIdErrorMessage() {
        return getByIdErrorMessage;
    }

    public String getSaveSuccessMessage() {
        return saveSuccessMessage;
    }

    public String getSaveErrorMessage() {
        return saveErrorMessage;
    }

    public String getUpdateSuccessMessage() {
        return updateSuccessMessage;
    }

    public String getUpdateErrorMessage() {
        return updateErrorMessage;
    }

    public String getDeleteSuccessMessage() {
        return deleteSuccessMessage;
    }

    public String getDeleteErrorMessage() {
        return deleteErrorMessage;
    }

}
