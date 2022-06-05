package app;

import data.HumanBeing;
import parser.ParserToXml;
import util.Response;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * CollectionManager Class
 *
 * managing a collection of items
 */
public class CollectionManager {
    LinkedList<HumanBeing> collection = new LinkedList<>();
    private Long id = 1L;

    private Response response = new Response();
    ZonedDateTime initTime = ZonedDateTime.now();

    public Response getResponse(){
        return response;
    }

    public void clearResponse() {
        response = new Response();
    }

    /**
     *
     * @return the smallest allowed id
     */
    public Long getId() {
        return id++;
    }

    public void help(LinkedList<String> description) {
        response.setObject(description);
    }

    /**
     * Merge collection from file and this one
     *
     * @param collectionFromFile collection was given from file
     * @param id the last id from file
     */
    public void mergeCollections(LinkedList<HumanBeing> collectionFromFile, Long id) {
        collection.addAll(collectionFromFile);
        this.id = id;
    }

    /**
     * Save collection to XML
     */
    public void save() {
        HashSet<Long> idList = new HashSet<>();

        /*for(HumanBeing element: collection) {
            if (element.getHasToothpick() == null) idList.add(element.getId());
            if (element.getImpactSpeed() == null) idList.add(element.getId());
            if (element.getWeaponType() == null) idList.add(element.getId());
            if (element.getMinutesOfWaiting() == null) idList.add(element.getId());
        }*/

        if (idList.isEmpty()) {
            ParserToXml parserToXml = new ParserToXml();
            parserToXml.parseToXml(collection);
        }
        else {
            System.out.println("Невозможно сохранить коллекцию, т.к. у элементов с id из списка есть поля = null");
            System.out.println(idList);
            idList.clear();
        }
    }

    /**
     * Print an information about collection
     */
    public void info() {
        response.setMessage(" - команда выполнена успешно. '\n' Тип - " + collection.getClass() + "\n"
                + "Количество элементов - " + collection.size() + "\n"
                + "Дата инициализации - " + initTime);
    }

    /**
     * Remove elements that greater than given one
     *
     * @param CompareElement the element to compare with
     */
    public void removeGreater(HumanBeing CompareElement) {
        collection.removeIf(element -> element.compareTo(CompareElement) > 0);
    }

    /**
     * Add an element to collection if it is smaller than the smallest existing one
     *
     * @param element element is needed to add
     */
    public void addIfMin(HumanBeing element) {
        element.setId(getId());
        Collections.sort(collection);
        if (collection.isEmpty() || collection.peekFirst().compareTo(element) >= 0) {
            collection.addFirst(element);
        } else {
            response.setMessage(" - элемент не добавлен, т.к. найден элемент меньше заданного.");
        }
    }

    /**
     * Find elements with given substring and print them
     *
     * @param subString substring to be found
     */
    public void filterStartsWithSoundtrackName(String subString) {
        response.setObject((LinkedList<? extends Serializable>) collection.stream()
                .filter(element -> element.getSoundtrackName().startsWith(subString)));
    }

    /**
     * Count the number of elements with smaller value of weapon type
     *
     * @param weaponType the value to be compared with
     */
    public void countLessThanWeaponType(String weaponType) {
        int amount = 0;
        for(HumanBeing element: collection) {
            if (element.getWeaponType().length() < weaponType.length()) {
                amount++;
            }
        }
        response.setMessage(" - выполнение команды прошло успешно. \n"
                            + "Количество элементов = " + amount);

    }

    /**
     * Print the collection in ascending order
     */
    public void printAscending() {
        response.setObject((LinkedList<? extends Serializable>) collection.stream().sorted(HumanBeing::compareTo));
    }

    /**
     * Remove the first element in collection
     */
    public void removeFirst() {
        collection.removeFirst();
    }

    /**
     * Print the collection
     */
    public void show() {
        if (collection.isEmpty()) {
            response.setMessage(" - команда прошла успешно. Коллекция пустая");
        }
        response.setObject(collection);
    }

    /**
     * Clear the collection
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Add an element to collection
     *
     * @param element element that is needed to add
     */
    public void add(HumanBeing element) {
        element.setId(getId());
        collection.add(element);
    }

    /**
     * Updating element's data
     *
     * @param updateId id to update the item by
     */
    public void updateById(Long updateId, HumanBeing object) {
        object.setId(updateId);

        if (!collection.removeIf(element -> element.getId() == updateId)) {
            response.setMessage(updateId + " - элемент не был удален, т.к. его нет в коллекции");
        } else {
            collection.add(object);
        }
    }


    /**
     *
     * @param deleteId id to delete the item by
     */
    public void removeById(Long deleteId) {
        if (!collection.removeIf(element -> element.getId() == deleteId)) {
            response.setMessage(deleteId + " - элемент не был удален, т.к. его нет в коллекции");
        }
    }
}

