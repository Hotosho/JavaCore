package lesson11.HomeWork;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        int number = 0;

        for (API api : apis) {
            if (api != null) {
                number += api.findRooms(price, persons, city, hotel).length;
            }
        }
        Room[] arrayFindRoom = new Room[number];

        number = 0;

        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                if (api != null) {
                    arrayFindRoom[number] = room;
                    number++;
                }
            }
        }
        return arrayFindRoom;
    }


    public Room[] check(API api1, API api2) {

        int number = 0;

        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons() &&
                        room.getCityName().equals(room1.getCityName()) && room.getHotelName().equals(room1.getHotelName()))
                    number++;
            }

        }

        Room[] sameRoom = new Room[number];

        number = 0;

        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons() &&
                        room.getCityName().equals(room1.getCityName()) && room.getHotelName().equals(room1.getHotelName())) {
                    sameRoom[number] = room;
                    number++;
                }
            }
        }

        return sameRoom;
    }

   /* public Room cheapestRomm(Room room, API api) {
        return null;
    } */

}
