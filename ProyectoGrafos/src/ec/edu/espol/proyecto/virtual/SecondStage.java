/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.virtual;

import ec.edu.espol.proyecto.auxiliar.Auxiliar;
import ec.edu.espol.proyecto.grafos.Edge;
import ec.edu.espol.proyecto.grafos.Vertex;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author CORE I7
 */
public class SecondStage {

    private StackPane rootS;
    private HashMap<String, List<Double>> map;
    private HashMap<String, Circle> otherMap;
    private List<Line> rutaCorta;
    private int contador;
    private String first;

    public SecondStage(MainStage main) {
        rootS = new StackPane();
        map = new HashMap<>();
        otherMap = new HashMap<>();
        rutaCorta = new LinkedList<>();
        cargarCoordenadas();
        generarRoot1(main);
    }

    private void generarRoot1(MainStage main) {
        
        main.getStage().setMaximized(true);
        main.getStage().setResizable(false);

        rootS.getChildren().add(new ImageView(new Image("mapa.jpg")));
        
        Label distance = new Label();
        distance.setTranslateX(550);
        distance.setTranslateY(-250);

        final double width = main.getScene().getWidth() / 2;
        final double height = main.getScene().getHeight() / 2;

        Button goBack = new Button("Atras");
        goBack.setAlignment(Pos.BOTTOM_RIGHT);
        goBack.setTranslateX(500);
        goBack.setTranslateY(350);
        goBack.setOnMouseClicked(e -> goBack(main));

        rootS.getChildren().addAll(goBack,distance);

        for (String id : map.keySet()) {
            Circle c = new Circle();
            c.setFill(Color.WHITE);
            c.setStroke(Color.BLACK);

            c.setRadius(8);
            List<Double> doubles = map.get(id);

            c.setTranslateX(doubles.get(0) - width);
            c.setTranslateY(doubles.get(1) - height);

            Text text = new Text(id);
            text.setUserData(main.getCiudades().get(id));
            text.setOnMouseClicked(e -> {
                System.out.println((String) text.getUserData());
                contador++;
                if (contador == 1) {
                    first = (String) text.getUserData();
                }

                if (contador == 2) {
                    distance.setText("");
                    contador = 0;
                    String tmp;
                    int temporal = 0;
                    rootS.getChildren().removeAll(rutaCorta);
                    rutaCorta.clear();
                    List<String> ruta = Auxiliar.calcularRutaCorta(main.getGraph(), main.getCiudades(), first, (String) text.getUserData());
                    int controller = 0;

                    for (String value : ruta) {
                        switch (controller) {
                            case 0:
                                first = value;
                                break;
                            case 1:
                                tmp = value.substring(2, value.length()-2);
                                temporal += Integer.parseInt(value.substring(2, value.length()-5));
                                break;
                            case 2:
                                generateLine(first,value);

                                controller = 0;
                                first = value;
                                break;
                        }
                        controller++;
                    }
                    
                    distance.setText("Distancia de Ruta: "+temporal+" km");
                }
            });

            text.setTranslateX(c.getTranslateX());
            text.setTranslateY(c.getTranslateY());

            otherMap.put(id, c);
            rootS.getChildren().addAll(c, text);
        }

        Button btnClean = new Button("Limpiar");
        btnClean.setTranslateX(500);
        btnClean.setTranslateY(300);

        btnClean.setOnMouseClicked(e -> {
            distance.setText("");
            contador = 0;
            rootS.getChildren().removeAll(rutaCorta);
            rutaCorta.clear();
        });

        Button btnShow = new Button("Mostrar");
        btnShow.setTranslateX(500);
        btnShow.setTranslateY(250);

        btnShow.setOnMouseClicked(e -> {
            generateAllPaths(main);

        });
        
        Label ta = new Label();
        llenar(ta,main);
        ta.setTranslateX(-550);
        ta.setTranslateY(0);

        rootS.getChildren().addAll(btnClean, btnShow,ta);

    }
    
    private void llenar(Label ta, MainStage main) {
        String result = "Ciudades: \n";
        int cont;

        String array[] = new String[40];

        for (String valor : main.getCiudades().keySet()) {
            cont = Integer.parseInt(valor);
            cont--;
            array[cont] = valor + ". " + main.getCiudades().get(valor) + "\n";
        }

        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        
        ta.setText(result);
    }

    private void cargarCoordenadas() {
        File file = new File("coordenadas.bin");
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file))) {
            map = (HashMap<String, List<Double>>) oos.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void goBack(MainStage main) {
        main.getStage().setMaximized(false);
        main.getStage().setResizable(true);
        main.getScene().setRoot(main.getRoot());

    }

    private void generateAllPaths(MainStage main) {
        for (Vertex<String> v : main.getGraph().getVertexes()) {
            for (Edge<String> e : v.getEdges()) {
                generateLine(e.getOrigin().getData(),e.getDestiny().getData());
            }
        }
    }
    
    private void generateLine(String s1, String s2) {
        Circle c1 = otherMap.get(s1);
        Circle c2 = otherMap.get(s2);

        double tempX;
        double tempY;

        tempX = calculate(c1.getTranslateX(), c2.getTranslateX());
        tempY = calculate(c1.getTranslateY(), c2.getTranslateY());

        Line line = new Line();
        line.setStartX(c1.getTranslateX());
        line.setStartY(c1.getTranslateY());

        line.setEndX(c2.getTranslateX());
        line.setEndY(c2.getTranslateY());

        line.setTranslateX(tempX);
        line.setTranslateY(tempY);

        rootS.getChildren().add(line);
        rutaCorta.add(line);
    }

    private double calculate(double d1, double d2) {
        double result;
        double temp;
        double temp2;
        if (d1 < 0 && d2 < 0) {
            if (d1 > d2) {
                result = ((d2 - d1) / 2) + d1;
            } else if (d2 > d1) {
                result = ((d1 - d2) / 2) + d2;
            } else {
                result = 0;
            }

        } else if (d1 > 0 && d2 > 0) {
            if (d1 > d2) {
                result = ((d1 - d2) / 2) + d2;
            } else if (d2 > d1) {
                result = ((d2 - d1) / 2) + d1;
            } else {
                result = 0;
            }
        } else {
            if (d1 > 0) {
                temp = d2 * (-1);
                temp2 = (d1 + temp) / 2;
                if (d1 > d2) {
                    result = d1 - temp2;
                } else {
                    result = d2 + temp2;
                }
            } else {
                temp = d1 * (-1);
                temp2 = (d2 + temp) / 2;
                if (d2 > d1) {
                    result = d2 - temp2;
                } else {
                    result = d1 + temp2;
                }
            }
        }
        return result;
    }

    public StackPane getRootS() {
        return rootS;
    }

    public void setRootS(StackPane rootS) {
        this.rootS = rootS;
    }

    public HashMap<String, List<Double>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, List<Double>> map) {
        this.map = map;
    }

    public HashMap<String, Circle> getOtherMap() {
        return otherMap;
    }

    public void setOtherMap(HashMap<String, Circle> otherMap) {
        this.otherMap = otherMap;
    }

    public List<Line> getRutaCorta() {
        return rutaCorta;
    }

    public void setRutaCorta(List<Line> rutaCorta) {
        this.rutaCorta = rutaCorta;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
    
    

}
