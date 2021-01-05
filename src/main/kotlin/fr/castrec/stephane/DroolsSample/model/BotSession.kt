package fr.castrec.stephane.DroolsSample.model

class BotSession(val answered: MutableList<Answer>) {
    var nextQuestion: Int? = null;

    fun getLastAnswer(): Answer? {
        return answered.last()
    }

    fun nbAnswered(): Int {
        return answered.size
    }

}