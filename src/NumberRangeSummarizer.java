import java.util.*;

/**
 *
 * TODO : Add class comment
 *
 */
public class NumberRangeSummarizer implements NumberRangeSummarizerInterface
{
    public static void main(String[] args)
    {
        NumberRangeSummarizer numberRange = new NumberRangeSummarizer();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        try {
            Collection<Integer> collectionInput = numberRange.collect(input);
            String range = numberRange.summarizeCollection(collectionInput);

            System.out.println(range);
        } catch (ClassCastException exc) {
            System.out.println("Error , check if the string doesn't contain a character");
        }


    }

    /**
     *
     * TODO : Add method comment
     * @return
     *
     */
    public Collection<Integer> collect(String input) {
        //Separate the numbers with ","
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];
//
        for (int i = 0; i < arrayOfString.length; i++) {
            integers[i] = Integer.parseInt(arrayOfString[i]);
        }

        // sorting the numbers

        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for (int integer : integers) {
            list.add(integer);

        }


        return list;

    }

    /**
     *
     * TODO : Add method comment
     *
     * @param input
     * @return
     *
     */
    public String summarizeCollection(Collection<Integer> input)
    {
        int count = 0;
        StringBuilder stringbuilder = new StringBuilder();


        //collection class created
        ArrayList<Integer> inputList;
        inputList = new ArrayList<>(input);
        int length = inputList.size();


        int start;
        int next;
        for (int a = 0; a < length; a++)
        {
            // CATERS FOR THE LAST ELEMENT OF THE LIST
            if (a == length - 1)
            {
                if(!inputList.get(length - 2).equals(inputList.get(length - 1)))
                {
                    stringbuilder.append(inputList.get(a)).append(",");
                }
                break;
            }
            // START IS FIRST ELEMENT
            start = inputList.get(a);

            next = inputList.get(a + 1);
            if (next == start + 1)
            {
                count++;
                int lowestBound = start;

                //GENERALLY IF THERE IS A CONSISTENT RANGE IN THE LIST APEND THE BEGINING AND END OF IT ELSE BREAK FROM THE LOOP

                // Loop until the range breaks - where the loop breaks is your upper bound for the current range.
                // TAKING THE BEGINING OF THE RANGE AND WHERE IT ENDS!!!
                for (int i = a + 1; ; i++)
                {
                    start = inputList.get(i);
                    next = inputList.get(i + 1);

                    if (next == start + 1)
                    {
                        count++;
                    }
                    else
                    {
                        a = i;
                        if (count != 0)
                        {
                            stringbuilder.append(lowestBound).append("-").append(inputList.get(i)).append(", ");
                        }
                        break;
                    }
                }
                count = 0;
            }
            else
            {
                // passes past the ones that have no range.
                stringbuilder.append(start).append(", ");
            }
        }
        //CONCATENATION
        String ranges = stringbuilder.toString();
        return ranges.substring(0, ranges.length() - 1);
    }


}
