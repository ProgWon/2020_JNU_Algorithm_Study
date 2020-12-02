class fourcal:
	def __init__(self, first, second):
		self.first = first
		self.second = second
	def setdata(self, first, second):
		self.first = first
		self.second = second
	def add(self):
		result = self.first + self.second
		return result
	def mul(self):
		result = self.first * self.second
		return result
	def sub(self):
		result = self.first - self.second
		return result
	def div(self):
		result = self.first - self.second
		return result

a = fourcal(4,2)

class morefourcal(fourcal):
	def pow(self):
		result = self.first ** self.second
		return result

a = morefourcal(4,2)

print(a.pow())
