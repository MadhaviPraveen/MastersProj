/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

/**
 *
 * @author ivatu
 */
public class OptionDTO {

    private int optionId;
    private String text;
    
    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OptionDTO(int optionId, String text) {
        this.optionId = optionId;
        this.text = text;
    }

    public OptionDTO() {
    }
    
}
