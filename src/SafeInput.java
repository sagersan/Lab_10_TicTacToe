import java.util.Scanner;

public class SafeInput {
    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                return value;
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. You entered: " + trash);
            }

        } while (!done);

        return 0;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // clear buffer
                return value;
            } else {
                String trash = pipe.nextLine(); // read bad input
                System.out.println("You must enter a valid double. You entered: " + trash);
            }

        } while (!done);

        return 0;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // clear buffer

                if (value >= low && value <= high) {
                    return value;
                } else {
                    System.out.println("You must enter a value between "
                            + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. You entered: "
                        + trash);
            }

        } while (true);

    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine(); // clear buffer

                if(value >= low && value <= high)
                {
                    return value;
                }
                else
                {
                    System.out.println("You must enter a value between "
                            + low + " and " + high + ".");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid double. You entered: "
                        + trash);
            }

        } while(true);
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                return true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Please enter Y or N.");
            }

        } while(true);
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value;

        do
        {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();

            if(value.matches(regEx))
            {
                return value;
            }
            else
            {
                System.out.println("Invalid input. Please try again.");
            }

        } while(true);
    }
    public static void prettyHeader(String msg)
    {
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        int spaces = (54 - msg.length()) / 2;

        System.out.print("***");

        for(int i = 0; i < spaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(int i = 0; i < (54 - spaces - msg.length()); i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}

