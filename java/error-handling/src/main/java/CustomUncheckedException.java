class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
    }

    CustomUncheckedException(String message) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
