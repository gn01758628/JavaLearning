package algorithm;
public class SortingAlgorithm {
	//Selection Sort 選擇排序法
	public static int[] selectionSort (int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	//Bubble Sort 冒泡排序法
	public static int[] bubbleSort (int[] arr) {
		for (int i = 0 ; i < arr.length - 1; i++) {
			boolean exchange = false;
			for (int j = i ; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					exchange = true;
				}
			}
			if (!exchange) {
				break;
			}
		}
		return arr;
	}

	//Insertion Sort 插入排序法
	public static int[] insertionSort (int[] arr) {
		for (int i = 1 ; i < arr.length; i++) {
			int hand = arr[i];
			int j = i - 1;
			while (j >= 0 && hand < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = hand;
		}
		return arr;
	}

	public static void main (String[] args) {
	}
}