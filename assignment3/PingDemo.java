/*
        Problem Statement: Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
        Use the system ping utility, do not use any deprecated methods.
*/

package Java_Assignment.assignment3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class PingHost {
    // Method to ping a given host & get the median of response time. Complexity: Time: O(nlogn), Space: O(n) , Where, n is the number of response times.
    public static double getMedianOfResponseTimeForHost(String host) {
        double medianOfResponseTime = 0.0d;
        ArrayList<Double> responseTimes = new ArrayList<>(); // create an ArrayList to store response times
        try {
            // Create ping command
            String pingCommand = "ping " + host;

            // Execute ping command  //imp code
            Process pingProcess = Runtime.getRuntime().exec(pingCommand);
            BufferedReader reader = new BufferedReader(new InputStreamReader(pingProcess.getInputStream()));
            System.out.println(pingProcess);
            System.out.println(reader);
            // Parse ping output to get ping times
            String line;
            while ((line = reader.readLine()) != null) {
                int timeIndex = line.indexOf("time=");
                if (timeIndex >= 0) { // check if "time=" pattern is found
                    try {
                        Double responseTime = Double.parseDouble(line.substring(timeIndex + 5, timeIndex + 7));
                        responseTimes.add(responseTime); // add response time to ArrayList
                        System.out.println("res"+responseTime);
                    } catch (NumberFormatException ex) {
                        System.out.println("Error parsing response time: " + ex.getMessage());
                    }
                }
            }
            medianOfResponseTime = getMedianForData(responseTimes);  //calaculating data
        } catch (Exception e) {
            System.out.println("Error pinging host: " + e.getMessage());
        }
        return medianOfResponseTime;
    }

    // Method to calculate the median for the given data Complexity: Time: O(nlogn) Space: O(1) , where n is the number of elements in the input ArrayList.
    public static double getMedianForData(List<Double> data) {
        Collections.sort(data);
        int size = data.size();
        return size % 2 == 0 ? (data.get(size / 2) + data.get(size / 2 - 1)) / 2.0 : data.get(size / 2);
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a host to ping: ");
        // Taking the user input
        String host = userInput.nextLine();
        double responseTime = getMedianOfResponseTimeForHost(host);
        System.out.println("Median of response time to ping: " + host + ": "+responseTime + " ms");
    }
}