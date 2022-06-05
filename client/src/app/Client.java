package app;

import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import util.Response;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import util.Request;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
    private final int SERVER_PORT = 8080;
    private final int BUFFER_SIZE = 1048576;
    private Socket socket;
    private InetAddress address;
    private InputStream inputStream;
    private OutputStream outputStream;
    private static Client client;

    public Client() {
        this.socket = new Socket();
    }

    public void setClient(final Client client) {
        Client.client = client;
    }

    public static Client getClient() {
        return Client.client;
    }

    public boolean connect() {
        try {
            address = InetAddress.getLoopbackAddress();
            socket = new Socket(address, SERVER_PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            System.out.println("Успешно подключились к серверу");
            return true;
        }
        catch (IOException e) {
            System.out.println("Сервер недоступен. \n");
            return false;
        }
    }

    public boolean reconnect() {
        int number = 1;
        while (!connect()) {
            System.out.println("Переподключение к серверу...");
            System.out.println("Попытка № " + number);
            if (number % 3 == 0) {
                System.out.println("Продолжить подключение? Введите 'Да' или 'Нет' с заглавной буквы");
                Scanner input = new Scanner(System.in);
                String choose = input.nextLine();
                if (choose.equals("Нет")) {
                    return false;
                }
            }
            number++;
        }
        return true;
    }

    public boolean isConnected() {
        return socket.isConnected();
    }

    public void close() {
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        }
        catch (IOException e) {
            System.out.println("Не удалось корректно завершить работу с сервером");
        }
    }

    public void sendRequest(Request request) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream output = new ObjectOutputStream(byteArrayOutputStream)) {
            output.writeObject(request);
            outputStream.write(byteArrayOutputStream.toByteArray());
        }
        catch (IOException e) {
            System.out.println("Не удалось отправить данные на сервер");
        }
    }

    public Response getResponse() {
        Response response = new Response();
        final ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        try {
            inputStream.read(buffer.array());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
            ObjectInputStream input = new ObjectInputStream(byteArrayInputStream);
            response = (Response)input.readObject();
        }
        catch (IOException e) {
            System.out.println("Ошибка получения данных с сервера");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Некорреткные данные с сервера");
        }
        return response;
    }
}