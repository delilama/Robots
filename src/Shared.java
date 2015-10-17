import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Shared {

    private Robot _robot;
    private int _defaultDelayBetweenTypedKeys = 40; //in milliseconds

    public static class KeyPressDto {

        public KeyPressDto() {
            this.ModifierKey = -1;
        }

        public KeyPressDto(int modKey, int vKey){
            this.ModifierKey = modKey;
            this.VKey = vKey;
        }

        public int ModifierKey;
        public int VKey;
    }

    public static void main(String[] args) throws AWTException {
        new Shared();
    }

    public Shared(Robot robot) throws AWTException {
        this._robot = robot;
    }

    public Shared() throws AWTException {
        this._robot = new Robot();
    }

    public void LeftClick() {
        this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this._robot.delay(200);
        this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        this._robot.delay(200);
    }

    /**
     * Will left click and hold for input seconds and then release
     *
     * @param timeToHold in milliseconds
     */
    public void LeftClickHoldAndRelease(int timeToHold) {
        this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this._robot.delay(timeToHold);
        this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        this._robot.delay(200);
    }

    /**
     * Clicks and holds left click ad infinitum (or until LeftClickHold() is called)
     */
    public void LeftClickHold() {
        this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void LeftClickRelease() {
        this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void RightClick() {
        this._robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        this._robot.delay(200);
        this._robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        this._robot.delay(200);
    }

    /**
     * Presses the Windows key
     */
    public void PressWindowsKey() {
        this._robot.keyPress(KeyEvent.VK_WINDOWS);
        this._robot.delay(200);
        this._robot.keyRelease(KeyEvent.VK_WINDOWS);
        this._robot.delay(200);
    }

    /**
     * Presses and release the input KeyEvent
     *
     * @param VK The KeyEvent
     */
    public void PressKey(int VK) {
        this._robot.keyPress(VK);
        this._robot.delay(200);
        this._robot.keyRelease(VK);
        this._robot.delay(200);
    }

    /**
     * Types out the string using the default delay between keys
     *
     * @param s
     */
    public void TypeThis(String s) {
        this.TypeThis(s, _defaultDelayBetweenTypedKeys);
    }

    /**
     * Types out the string using the input delay between each key press
     *
     * @param s
     * @param delayTimeBetweenKeys In milliseconds
     */
    public void TypeThis(String s, int delayTimeBetweenKeys) {
        String[] bytes = s.split("");
        for (String str : bytes) {
            KeyPressDto dto = this.GetKeyPressDtoFromString(str);
            this._robot.delay(delayTimeBetweenKeys);
            if (dto.ModifierKey > -1) {
                this._robot.keyPress(dto.ModifierKey);
                this._robot.delay(100);
                this._robot.keyPress(dto.VKey);
                this._robot.keyRelease(dto.VKey);
                this._robot.delay(40);
                this._robot.keyRelease(dto.ModifierKey);
            }
            else{
                this._robot.keyPress(dto.VKey);
                this._robot.keyRelease(dto.VKey);
            }
        }
    }

    /**
     * Waits for time to pass
     * @param time In milliseconds
     */
    public void WaitForTimeToElapse(int time){
        this._robot.delay(time);
    }

    /**
     * Gets the KeyEvent from a string
     *
     * @param s
     * @return A KeyPressDto
     */
    public KeyPressDto GetKeyPressDtoFromString(String s) {
        if (s.isEmpty() || s == null)
            throw new IllegalArgumentException("Input string was empty");

        KeyPressDto dto = new KeyPressDto();

        switch (s) {
            case "a":
                dto.VKey = KeyEvent.VK_A;
                break;
            case "b":
                dto.VKey = KeyEvent.VK_B;
                break;
            case "c":
                dto.VKey = KeyEvent.VK_C;
                break;
            case "d":
                dto.VKey = KeyEvent.VK_D;
                break;
            case "e":
                dto.VKey = KeyEvent.VK_E;
                break;
            case "f":
                dto.VKey = KeyEvent.VK_F;
                break;
            case "g":
                dto.VKey = KeyEvent.VK_G;
                break;
            case "h":
                dto.VKey = KeyEvent.VK_H;
                break;
            case "i":
                dto.VKey = KeyEvent.VK_I;
                break;
            case "j":
                dto.VKey = KeyEvent.VK_J;
                break;
            case "k":
                dto.VKey = KeyEvent.VK_K;
                break;
            case "l":
                dto.VKey = KeyEvent.VK_L;
                break;
            case "m":
                dto.VKey = KeyEvent.VK_M;
                break;
            case "n":
                dto.VKey = KeyEvent.VK_N;
                break;
            case "o":
                dto.VKey = KeyEvent.VK_O;
                break;
            case "p":
                dto.VKey = KeyEvent.VK_P;
                break;
            case "q":
                dto.VKey = KeyEvent.VK_Q;
                break;
            case "r":
                dto.VKey = KeyEvent.VK_R;
                break;
            case "s":
                dto.VKey = KeyEvent.VK_S;
                break;
            case "t":
                dto.VKey = KeyEvent.VK_T;
                break;
            case "u":
                dto.VKey = KeyEvent.VK_U;
                break;
            case "v":
                dto.VKey = KeyEvent.VK_V;
                break;
            case "w":
                dto.VKey = KeyEvent.VK_W;
                break;
            case "x":
                dto.VKey = KeyEvent.VK_X;
                break;
            case "y":
                dto.VKey = KeyEvent.VK_Y;
                break;
            case "z":
                dto.VKey = KeyEvent.VK_Z;
                break;
            case "A":
                dto.VKey = KeyEvent.VK_A;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "B":
                dto.VKey = KeyEvent.VK_B;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "C":
                dto.VKey = KeyEvent.VK_C;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "D":
                dto.VKey = KeyEvent.VK_D;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "E":
                dto.VKey = KeyEvent.VK_E;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "F":
                dto.VKey = KeyEvent.VK_F;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "G":
                dto.VKey = KeyEvent.VK_G;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "H":
                dto.VKey = KeyEvent.VK_H;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "I":
                dto.VKey = KeyEvent.VK_I;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "J":
                dto.VKey = KeyEvent.VK_J;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "K":
                dto.VKey = KeyEvent.VK_K;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "L":
                dto.VKey = KeyEvent.VK_L;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "M":
                dto.VKey = KeyEvent.VK_M;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "N":
                dto.VKey = KeyEvent.VK_N;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "O":
                dto.VKey = KeyEvent.VK_O;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "P":
                dto.VKey = KeyEvent.VK_P;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "Q":
                dto.VKey = KeyEvent.VK_Q;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "R":
                dto.VKey = KeyEvent.VK_R;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "S":
                dto.VKey = KeyEvent.VK_S;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "T":
                dto.VKey = KeyEvent.VK_T;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "U":
                dto.VKey = KeyEvent.VK_U;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "V":
                dto.VKey = KeyEvent.VK_V;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "W":
                dto.VKey = KeyEvent.VK_W;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "X":
                dto.VKey = KeyEvent.VK_X;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "Y":
                dto.VKey = KeyEvent.VK_Y;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "Z":
                dto.VKey = KeyEvent.VK_Z;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "`":
                dto.VKey = KeyEvent.VK_BACK_QUOTE;
                break;
            case "0":
                dto.VKey = KeyEvent.VK_0;
                break;
            case "1":
                dto.VKey = KeyEvent.VK_1;
                break;
            case "2":
                dto.VKey = KeyEvent.VK_2;
                break;
            case "3":
                dto.VKey = KeyEvent.VK_3;
                break;
            case "4":
                dto.VKey = KeyEvent.VK_4;
                break;
            case "5":
                dto.VKey = KeyEvent.VK_5;
                break;
            case "6":
                dto.VKey = KeyEvent.VK_6;
                break;
            case "7":
                dto.VKey = KeyEvent.VK_7;
                break;
            case "8":
                dto.VKey = KeyEvent.VK_8;
                break;
            case "9":
                dto.VKey = KeyEvent.VK_9;
                break;
            case "-":
                dto.VKey = KeyEvent.VK_MINUS;
                break;
            case "=":
                dto.VKey = KeyEvent.VK_EQUALS;
                break;
            case "~":
                dto.VKey = KeyEvent.VK_BACK_QUOTE;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "!":
                dto.VKey = KeyEvent.VK_1;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "@":
                dto.VKey = KeyEvent.VK_2;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "#":
                dto.VKey = KeyEvent.VK_3;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "$":
                dto.VKey = KeyEvent.VK_4;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "%":
                dto.VKey = KeyEvent.VK_5;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "^":
                dto.VKey = KeyEvent.VK_6;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "&":
                dto.VKey = KeyEvent.VK_7;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "*":
                dto.VKey = KeyEvent.VK_8;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "(":
                dto.VKey = KeyEvent.VK_LEFT_PARENTHESIS;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case ")":
                dto.VKey = KeyEvent.VK_9;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "_":
                dto.VKey = KeyEvent.VK_0;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "+":
                dto.VKey = KeyEvent.VK_PLUS;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "\t":
                dto.VKey = KeyEvent.VK_TAB;
                break;
            case "\n":
                dto.VKey = KeyEvent.VK_ENTER;
                break;
            case "[":
                dto.VKey = KeyEvent.VK_OPEN_BRACKET;
                break;
            case "]":
                dto.VKey = KeyEvent.VK_CLOSE_BRACKET;
                break;
            case "\\":
                dto.VKey = KeyEvent.VK_BACK_SLASH;
                break;
            case "|":
                dto.VKey = KeyEvent.VK_BACK_SLASH;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "{":
                dto.VKey = KeyEvent.VK_OPEN_BRACKET;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "}":
                dto.VKey = KeyEvent.VK_CLOSE_BRACKET;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case ";":
                dto.VKey = KeyEvent.VK_SEMICOLON;
                break;
            case ":":
                dto.VKey = KeyEvent.VK_SEMICOLON;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "\'":
                dto.VKey = KeyEvent.VK_QUOTE;
                break;
            case "\"":
                dto.VKey = KeyEvent.VK_QUOTE;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case ",":
                dto.VKey = KeyEvent.VK_COMMA;
                break;
            case "<":
                dto.VKey = KeyEvent.VK_COMMA;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case ".":
                dto.VKey = KeyEvent.VK_PERIOD;
                break;
            case ">":
                dto.VKey = KeyEvent.VK_PERIOD;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case "/":
                dto.VKey = KeyEvent.VK_SLASH;
                break;
            case "?":
                dto.VKey = KeyEvent.VK_SLASH;
                dto.ModifierKey = KeyEvent.VK_SHIFT;
                break;
            case " ":
                dto.VKey = KeyEvent.VK_SPACE;
                break;
            case "PAGE_UP":
                dto.VKey = KeyEvent.VK_PAGE_UP;
                break;
            case "PAGE_DOWN":
                dto.VKey = KeyEvent.VK_PAGE_DOWN;
                break;
            case "ESCAPE":
                dto.VKey = KeyEvent.VK_ESCAPE;
                break;
            case "UP_ARROW":
                dto.VKey = KeyEvent.VK_UP;
                break;
            case "DOWN_ARROW":
                dto.VKey = KeyEvent.VK_DOWN;
                break;
            case "LEFT_ARROW":
                dto.VKey = KeyEvent.VK_LEFT;
                break;
            case "RIGHT_ARROW":
                dto.VKey = KeyEvent.VK_RIGHT;
                break;
            default:
                throw new IllegalArgumentException("Cannot find character " + s);
        }

        return dto;
    }

    /**
     * Locks the windows station as if Windows + L was pressed
     */
    public void LockWindowsStation() {
        throw new NotImplementedException();
        /*this._robot.keyPress(KeyEvent.VK_WINDOWS);
        this._robot.delay(200);
        this._robot.keyPress(KeyEvent.VK_L);
        this._robot.delay(200);
        this._robot.keyRelease(KeyEvent.VK_L);
        this._robot.keyRelease(KeyEvent.VK_WINDOWS);*/
    }

    public String Ping(){
        return "I am alright.";
    }

    public List<KeyPressDto> ConvertStringToKeyPressDtos(String s){
        List<KeyPressDto> list = new ArrayList<KeyPressDto>();

        if(s != null && s.length() > 0){
            String[] sArray = s.split("");
            for (int i = 0; i < sArray.length; i++) {
                String current = sArray[i];
                if(current.equals("\\")){
                    list.add(GetKeyPressDtoFromString(current + sArray[i + 1]));
                    i++;
                }
                else{
                    list.add(GetKeyPressDtoFromString(current));
                }
            }
        }
        return list;
    }

    /*public void LockWindows() {
        try {
            Runtime.getRuntime().exec("rundll32 user32.dll,LockWorkStation");
        } catch (java.io.IOException ioe) {

        }
    }*/
}
